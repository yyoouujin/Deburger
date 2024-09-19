//발주상세 조회
	$('tbody > tr').on('click', makeTag);
	
	function makeTag(){
		
		let checkText = $(event.currentTarget).children().eq(6);
		let selectLogistic = $(event.currentTarget).children().eq(7);
		console.log(selectLogistic);
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
				
				console.log('창고재고',data);
				let logisticStock = data;
				
		    	//해당 주문번호의 전체 발주수량 조회
		    	$.ajax({
		    		url:"orderAllStock?orderNumber=" + odn,
		    		method:"GET"
		    	})
		    	.done(data => {
					let orderStock = data;
		    		console.log('주문발주수량',orderStock);
		    		
		    		//1) 재고확인 N 또는 Y 출력
		    		if (logisticStock != -1) { //창고에 재고가 하나도 없는게 아니면~ 비교시작
						if(orderStock > logisticStock) {
							checkText.text("N");
						} else {
							checkText.text("Y");
						}
					} else {
						checkText.text("N");
					}
					
					
					//2) 'N'일 시 창고 변경이 가능하도록 (주문발주수량보다 많은 창고 select)
					if (checkText.text() == 'N'){
						
						$.ajax({
							url:"selectLogistics?orderNumber=" + odn,
							method:"GET"
						})
						.done(data => {
							console.log(data[0].logisticsName);
						})
						.fail(err => console.log(err));
						
						let tag = `<select><option>선택</option></select>`
						selectLogistic.html(tag);
						
						
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
            console.log(`${data[0].cancelOperation}`);
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
	}
	
	
	//모달 초기화
	$('#modalDialogScrollable').on('hidden.bs.modal', function () {
		document.querySelector('.order_detail').innerHTML="";
		document.querySelector('.modal-title').innerHTML="";
		document.querySelector('#top-tag').innerHTML="";
		document.querySelector('#cancleBtn').innerHTML="";
		
	});