document.getElementById('save').onclick = function () {

			
	
	
	
    if(document.getElementById('nameAnswer').value == ''){

        document.getElementById('error').innerHTML = 'Empty message';
        document.getElementById('error').style.backgroundColor= 'red';
      
        
        
           
    }else{
         	
      	
    	var answer ={
    		
    			
    				text : document.getElementById('nameAnswer').value,
    				correct : document.getElementById('cor').value,
    				question : { 
    					id:document.getElementById('idQuestion').value 
    					}
    			}	
    
    	$.ajax({
    		
    		 url : 'saveGetAnswer?'+$('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
             method : 'POST',
             contentType: 'application/json; charset=UTF-8',
             dataType : 'json',
             data : JSON.stringify(answer),
             success : function (res) {

    		  document.getElementById('error').innerHTML = 'Answer Added';
        document.getElementById('error').style.backgroundColor= 'red';
             }
    	})
    	
      
    	
    	
    }  
    
}

   



