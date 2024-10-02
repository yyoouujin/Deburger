const urlParams = new URL(location.href).searchParams;
const lid = urlParams.get('logisticsId');

//물류창고 필요재고
$.ajax({
	url: 'requireStock?logisticsId=' + lid,
	method: 'GET',
})
	.done((data) => {
		let tag = `<span class="text-danger pt-3 fw-bold">${data.length}</span>`;
		$('#requireStock').append(tag);
	})
	.fail((err) => console.log(err));

//물류창고 충분재고
$.ajax({
	url: 'enoughStock?logisticsId=' + lid,
	method: 'GET',
})
	.done((data) => {
		let tag = `<span class="text-primary pt-3 fw-bold">${data.length}</span>`;
		$('#enoughStock').append(tag);
	})
	.fail((err) => console.log(err));

//물류창고 정보
logisticDetail();

function logisticDetail() {
	$.ajax({
		url: 'logisticDetailInfoAjax?logisticsId=' + lid,
		method: 'GET',
	})
		.done((data) => {
			$('#logiIdAjax').html(`${data[0].logisticsId}`);
			$('#lId').val(`${data[0].logisticsId}`);
			$('#lname').val(`${data[0].logisticsName}`);
			$('#tel').val(`${data[0].phone}`);

			$('#sample6_postcode').val(`${data[0].postal}`);
			$('#sample6_address').val(`${data[0].basicsAddress}`);
			$('#sample6_extraAddress').val(`${data[0].detailsAddress}`);
			$('#sample6_detailAddress').val(`${data[0].note}`);
			$('#pId').val(`${data[0].personId}`);
		})
		.fail((err) => console.log(err));

	//담당자 정보 select 박스
	$.ajax({
		url: 'selectDBGidAjax',
		method: 'GET',
	})
		.done((data) => {
			data.forEach((ele) => {
				let tag = `<option value=${ele.personId}>${ele.name} (${ele.personId})</option>`;
				$('#pId').append(tag);
			});
		})
		.fail((err) => console.log(err));
}

//초기화 버튼 (날리지 않고 현재 창고정보를 재호출)
$('#resetBtn').on('click', logisticDetail);

//수정 버튼 AJAX
$('#updateBtn').on('click', updateAjax);

function updateAjax() {
	let dataObj = getFormData();
	console.log(dataObj);

	$.ajax('logisticUpdate', {
		type: 'post',
		//contentType : 'application/json',
		data: dataObj,
	})
		.done((result) => {

			Swal.fire({
				title: '창고 정보를 수정하시겠습니까?',
				icon: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: '승인',
				cancelButtonText: '취소'
			})
				.then((result) => {
					if (result.isConfirmed) {
						Swal.fire(
							'창고정보 수정이 완료되었습니다',
							'',
							'success'
						).then(function() {
							document.location.href = document.location.href;
						});
					} else {
						Swal.fire(
							'창고정보 수정이 취소되었습니다',
							'',
							'error'
						)
					}
				})
		})
		.fail((err) => console.log(err));
}

function getFormData() {
	let formAry = $('form[name="updateForm"]').serializeArray();
	let formObj = {};

	$.each(formAry, function(idx, tag) {
		console.log(tag.name + ':' + tag.value);
		formObj[tag.name] = tag.value;
	});
	return formObj;
}

//주소 API
function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') {
				// 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else {
				// 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += extraAddr !== '' ? ', ' + data.buildingName : data.buildingName;
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById('sample6_extraAddress').value = extraAddr;
			} else {
				document.getElementById('sample6_extraAddress').value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById('sample6_address').value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById('sample6_detailAddress').focus();
		},
	}).open();
}

//재료상세 조회
$('tbody > tr').on('click', makeTag);

function makeTag() {
	let tr = event.currentTarget;
	let mid = $(tr).data('mid');
	console.log(mid);
	//let url = "http://localhost:8094/deburger/stockInfoAjax?materialNumber" + mid;

	$.ajax({
		url: 'stockInfoAjax?materialNumber=' + mid + '&logisticsId=' + lid,
		method: 'GET',
	})
		.done((data) => {
			$('.modal-title').append(`${data[0].materialName}`);
			let stock = document.getElementById(data[0].materialNumber).dataset.stock;

			let tag = ` 
						<h5 hidden><b>제료코드 : </b><span id="hidden_num">${data[0].materialNumber}</span></h5>
						<h5 hidden><b>업체ID : </b><span id="hidden_client">${data[0].clientId}</span></h5>
						<h5 hidden><b>필요개수: : </b><span id="hidden_stock">${stock}</span></h5>
                    	<h5><b>분류 : </b><span id="mate_class">${data[0].materialClassification}</span></h5>
                    	<h5><b>용량 : </b><span id="mate_unit">${data[0].unit}</span></h5>
                    	<h5><b>안전수량 : </b><span id="mate_safetyStock">${data[0].logisticsSafetyStock}개</span></h5>
                    	<h5><b>거래처 : </b><span id="mate_supplier">${data[0].aggclientName}</span></h5>`;

			$('#top-tag').html(tag); //append는 계속 갖다 붛히는거, html로 초기화

			data.forEach((element) => {
				let tr = document.createElement('tr');
				$(tr).append(`<td>${element.inDay}</td>`);
				$(tr).append(`<td>${element.expirationLimit}</td>`);
				$(tr).append(`<td>${element.inCount}</td>`);
				$('.mat_detail').append(tr);
			});
		})
		.fail((err) => console.log(err));
}

//발주버튼 클릭 시 발주 페이지로 이동
$('#orderBtn').on('click', function() {
	let materialNumber = document.getElementById('hidden_num').innerHTML;
	let clientId = document.getElementById('hidden_client').innerHTML;
	let logisticsSafetyStock = document.getElementById('hidden_stock').innerHTML;

	location.href = `/deburger/materialOrder?logisticsId=${lid}&materialNumber=${materialNumber}&clientId=${clientId}&logisticsSafetyStock=${logisticsSafetyStock}`;
});

//모달 초기화
$('#modalDialogScrollable').on('hidden.bs.modal', function() {
	document.querySelector('.mat_detail').innerHTML = '';
	document.querySelector('.modal-title').innerHTML = '';
	document.querySelector('#top-tag').innerHTML = '';
});

//삭제버튼
$('#deleteBtn').on('click', function() {
	location.href = '/deburger/logisticDelete?logisticsId=' + lid;
});
