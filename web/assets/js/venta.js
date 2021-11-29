/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.addEventListener("DOMContentLoaded", function(event) {
    
    setTimeout(function(){
        
        const inputIdUsuario = document.getElementById('IdUsuarioForm');
        const idtipousuarioform = inputIdUsuario.dataset.idtipousuarioform;

        if(idtipousuarioform){
            console.log('AQUI idtipousuarioform',idtipousuarioform);
            document.getElementById('selectTipoUsuario').value = idtipousuarioform;
        }
        
    },100);
    
});


