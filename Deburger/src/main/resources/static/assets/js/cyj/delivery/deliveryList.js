

//발주상세 조회
	$('tbody > tr').on('click', makeTag);
	
	function makeTag(event){
		//console.log(event.target);
		
		//select 박스 선택 시 이벤트 막기
		if (event.target.tagName == 'SELECT'){
			return;
		}
		
		//이미 선택되면 다시 그려지지 않게
		if ($(event.target).closest('tr').find('SELECT').length > 0) {
			return;
		}
		
		//발주상태가 승인 완료이면 리턴(예정)
		
		
		let checkText = $(event.currentTarget).children().eq(6);
		let selectLogistic = $(event.currentTarget).children().eq(7);
		let tr = event.currentTarget;
		let odn = $(tr).data('odn');
		let lid = $(tr).data('lid');
		
		checkStock();
		
		function checkStock() {
			
	    	//해당 주문번호의 담당물류창고 재고 전체조회
	    	$.ajax({
	    		url:"logisticAllStock?orderNumber=" + odn,
	    		method:"GET"
	    	})
	    	.done(data => {

				let logisticStock = data;
				
		    	//해당 주문번호의 전체 발주수량 조회
		    	$.ajax({
		    		url:"orderAllStock?orderNumber=" + odn,
		    		method:"GET"
		    	})
		    	.done(data => {
					let orderStock = data;
		    		//1) 재고확인 N 또는 Y 출력
		    		if (logisticStock != -1) { //창고에 재고가 하나도 없는게 아니면~ 비교시작
						if(orderStock > logisticStock) {
							checkText.text("N");
						} else {
							checkText.text("Y");
						}
					}

				//2) 'N'일 시 창고 변경이 가능하도록 (주문발주수량보다 많은 창고 select)
				let selecttag = $(`<select class="selectBox"></select>`)
				
				if (checkText.text() == 'N'){
					$.ajax({
						url:"selectLogistics?orderNumber=" + odn,
						method:"GET"
					})
					.done(data => {
						
						data.forEach( element => {
							let tag = `<option value="${element.logisticsId}">${element.logisticsName}</option>`
							$(selecttag).append(tag);
						});
						$(event.target).closest('tr').find('.selectLogistics').html(selecttag);
						
						//창고 선택 후 발주승인으로 넘어가기
						const selectElement = document.querySelector(".selectBox");

						selectElement.addEventListener("change", (event) => {
							
							const ctn = $(event.target).val(); //창고번호
							console.log(ctn);
							const odn = $(event.target).closest('tr').data('odn'); //주문번호
							const dataObj = {"orderNumber":odn, "logisticsId":ctn};
							
							//발주상태 변경
							$.ajax( 'oderappUpdate' ,{
								type:'post',
								data: dataObj
								//contentType : 'application/json',
							})
							.done( result => {
								if(confirm('발주 승인 하시겠습니까?')) {
									location.href="/deburger/deliveryList";
								}
							})
							.fail(err => console.log(err));
						});

						
					})
					.fail(err => console.log(err));
					}
					
					else { //'Y' 일 시 발주승인 버튼이 나올 수 있도록
						let dbtn = `<button type="button" class="btn btn-primary" data-bs-dismiss="modal">발주승인</button>`
						$('#deliveryRecognizeBtn').append(dbtn);
					}
					
		    	})
		    	.fail(err => console.log(err));
	    	})
	    	.fail(err => console.log(err));
		} //checkStock 끝
		
		
		
		$.ajax({
			url:"deliveryInfo?orderNumber=" + odn + "&logisticsId=" + lid,
			method:"GET"
		})
		.done(data => {
			
			$('.modal-title').append(`${data[0].orderNumber}`);
			
			let tag = `
					<h5><b>가맹점번호 : </b><span id="store_id">${data[0].storeNumber}</span></h5>
					<h5><b>가맹점명 : </b><span id="store_name">${data[0].storeName}</span></h5>
                	<h5><b>전화번호 : </b><span id="store_tel">${data[0].phone}</span></h5>
                	<h5><b>점주 : </b><span id="shop_keeper">${data[0].shopkeeper}</span></h5>
                	<h5><b>이메일 : </b><span id="shop_email">${data[0].email}</span></h5>
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
            }
		})
		.fail(err => console.log(err))
		
	} //maketag 끝






	
	//모달 초기화
	$('#modalDialogScrollable').on('hidden.bs.modal', function () {
		document.querySelector('.order_detail').innerHTML="";
		document.querySelector('.modal-title').innerHTML="";
		document.querySelector('#top-tag').innerHTML="";
		document.querySelector('#cancleBtn').innerHTML="";
		document.querySelector('#deliveryRecognizeBtn').innerHTML="";
	});