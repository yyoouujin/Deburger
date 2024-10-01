//발주상세 조회
$('tbody > tr').on('click', makeTag);

function makeTag(event) {

	let checkText = $(event.currentTarget).children().eq(6);
	console.log(checkText.text());
	let tr = event.currentTarget;
	let odn = $(tr).data('odn');
	let lid = $(tr).data('lid');
	checkStock();

	function checkStock() {

		let dbtn = `<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="dBtn">발주승인</button>`
		$('#deliveryRecognizeBtn').append(dbtn);

		//발주승인버튼 클릭 시 승인상태 변경
		const deliveryRecognizeBtn = document.querySelector('#deliveryRecognizeBtn');
		deliveryRecognizeBtn.addEventListener("click", (event) => {

			const findLogi = $('#shop_logi').html();//창고번호
			const findOdn = $('#findOdn').html();//주문번호
			const findSelectLogi = $('#selectLogi').html();

			if (findLogi.length == 10) { //창고번호 길이가 10이면 = select 박스로 선택이 안된거

				const dataObj = { "orderNumber": findOdn, "logisticsId": findLogi };

				//발주 승인 Sweet Alert
				Swal.fire({
					title: '발주 승인하시겠습니까?',
					icon: 'question',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: '승인',
					cancelButtonText: '취소'
				})
					.then((result) => {
						if (result.isConfirmed) {
							//발주상태 변경
							$.ajax('oderappUpdate', {
								type: 'post',
								data: dataObj
							})
								.done(result => {
									Swal.fire(
										'발주 승인 완료',
										'',
										'success'
									).then(function () {
										document.location.href = document.location.href;
									})
									
								})
								.fail(err => console.log(err));
						} else {
							Swal.fire(
								'목록으로 돌아갑니다',
								'',
								'error'
							)
						}
					})
			} else { //셀렉트박스로 선택된 물류창고로 변경
				const dataObj = { "orderNumber": findOdn, "logisticsId": findSelectLogi };

				Swal.fire({
					title: '해당 물류창고로 발주 승인하시겠습니까?',
					icon: 'question',
					showCancelButton: true,
					confirmButtonColor: '#3085d6',
					cancelButtonColor: '#d33',
					confirmButtonText: '승인',
					cancelButtonText: '취소'
				})
					.then((result) => {
						if (result.isConfirmed) {
							//발주상태 변경
							$.ajax('oderappUpdate', {
								type: 'post',
								data: dataObj
							})
								.done(result => {
									Swal.fire(
										'발주 승인 완료',
										'',
										'success'
									).then(function() {
										document.location.href = document.location.href;
									});
								})
								.fail(err => console.log(err));
						} else {
							Swal.fire(
								'목록으로 돌아갑니다',
								'',
								'error'
							)
						}
					});
			}
		}); //승인버튼 클릭이벤트 끗
	} //checkStock 끝



	//모달창 띄우기
	$.ajax({
		url: "deliveryInfo?orderNumber=" + odn + "&logisticsId=" + lid,
		method: "GET"
	})
		.done(data => {

			$('.modal-title').append(`${data[0].orderNumber}`);
			$('.modal-title').data('odn', `${data[0].orderNumber}`);

			let tag = `
					<h6><b>주문번호 : </b><span id="order_num">${data[0].orderNumber}</span></h6>
					<h6><b>가맹점번호 : </b><span id="store_id">${data[0].storeNumber}</span></h6>
					<h6><b>가맹점명 : </b><span id="store_name">${data[0].storeName}</span></h6>
                	<h6><b>전화번호 : </b><span id="store_tel">${data[0].phone}</span></h6>
                	<h6><b>점주 : </b><span id="shop_keeper">${data[0].shopkeeper}</span></h6>
                	<h6><b>이메일 : </b><span id="shop_email">${data[0].email}</span></h6>
                	<h6><b>담당창고 : </b><span id="shop_logi">${data[0].logisticsId}</span></h6>
                	`
			$('#top-tag').html(tag);

			data.forEach(element => {
				let tr = document.createElement('tr');
				$(tr).append(`<td>${element.materialNumber}</td>`);
				$(tr).append(`<td>${element.materialName}</td>`);
				$(tr).append(`<td>${element.count}</td>`);
				$(tr).append(`<td>${element.unit}</td>`);
				$('.order_detail').append(tr);
			});

			//취소요청일 경우에만 버튼 활성화
			let cbtn = `<button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소승인</button>`
			if (`${data[0].cancelOperation}` == 'J2') {
				$('#cancleBtn').append(cbtn);

				//취소승인 버튼 클릭 시 승인상태 변경
				const cancleBtn = document.querySelector('#cancleBtn');
				cancleBtn.addEventListener("click", (event) => {

					const findOdn = $('#findOdn').html();//주문번호
					const dataObj = { "orderNumber": findOdn };

					//취소 승인 Sweet Alert
					Swal.fire({
						title: '취소 승인하시겠습니까?',
						icon: 'warning',
						showCancelButton: true,
						confirmButtonColor: '#3085d6',
						cancelButtonColor: '#d33',
						confirmButtonText: '승인',
						cancelButtonText: '취소'
					})
						.then((result) => {
							if (result.isConfirmed) {
								//취소상태 변경
								$.ajax('canceloperationUpdate', {
									type: 'post',
									data: dataObj
								})
									.done(result => {
										Swal.fire(
											'취소 승인 완료',
											'',
											'success'
										).then(function() {
											document.location.href = document.location.href;
										})
									})
									.fail(err => console.log(err));
							}
						})
				}); //취소승인 버튼 클릭 시 승인상태 변경 이벤트 끝
			} //취소요청일 경우에만 버튼 활성화 끝

			//'N'일 시 창고 변경이 가능하도록 (주문발주수량보다 많은 창고 select)
			if (checkText.text() == 'N') {
				$.ajax({
					url: "selectLogistics?orderNumber=" + odn,
					method: "GET"
				})
					.done(data => {
						document.querySelector('#shop_logi').innerText = "";
						let selectTag = `<select class="selectBox"><select>`
						console.log(selectTag);
						$('#shop_logi').append(selectTag);
						data.forEach(element => {
							let tag = `<option id="selectLogi" value="${element.logisticsId}">${element.logisticsId}</option>`
							console.log(tag);
							$('.selectBox').append(tag);
						});
					})
					.fail(err => console.log(err));
			}
		})
		.fail(err => console.log(err))
} //maketag 끝


//모달 초기화
$('#modalDialogScrollable').on('hidden.bs.modal', function() {
	document.querySelector('.order_detail').innerHTML = "";
	document.querySelector('.modal-title').innerHTML = "";
	document.querySelector('#top-tag').innerHTML = "";
	document.querySelector('#cancleBtn').innerHTML = "";
	document.querySelector('#deliveryRecognizeBtn').innerHTML = "";
});