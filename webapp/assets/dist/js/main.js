const listar = () =>{
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    $.ajax({
        type: 'GET',
        url: contextPath + '/ServletGadgets?action=Listar'
    }).done(function(response){
          console.log(response);
        var aparato = response;
        let table = "";
        $('#Aparatos_listar').empty();
        $.each(aparato, function(i,item){
            let list = item;
            if(list.length > 0){
                for(let i = 0; i < list.length; i++){
                    let stat = list[i].status;
                    var funciones;
                    if(stat===1){
                        funciones = `
                         <button type="button" class="btn btn-primary btn-sm btn-modificar" data-bs-target="#Modalmodificar" data-bs-toggle="modal" data-idprod="${list[i].id}" data-nombre="${list[i].nombre}" data-fechareg="${list[i].fecharegistro}" data-calle="${list[i].direccion_fabricante.calle}" data-colonia="${list[i].direccion_fabricante.colonia}" data-codpost="${list[i].direccion_fabricante.codigopostal}" data-estado="${list[i].direccion_fabricante.estado}" data-pais="${list[i].direccion_fabricante.pais}"> Modificar</button>
                <button type="button" class="btn btn-danger btn-sm btn-eliminar" data-bs-target="#ModalEliminar" data-bs-toggle="modal" data-idprod="${list[i].id}" > Eliminar</button>
                        `;
                    }else{
                        funciones = ` <button type="button" class="btn btn-info btn-sm btn-detalles" data-bs-target="#Modaldetalles" data-bs-toggle="modal" data-idprod="${list[i].idproducto}" > Info</button>`
                    }
                    table += `
            <tr>
                <td>${i+1}</td>
                <td>${list[i].nombre}</td>
                <td>${list[i].direccion_fabricante.calle}, ${list[i].direccion_fabricante.colonia},C.P-${list[i].direccion_fabricante.codigo_postal}</td>
                <td>${list[i].direccion_fabricante.pais}</td>
                <td>${estado}</td>
                <td>
                ${funciones}
               </td>
            </tr>
            `;
                }
            }else{
                table = `
		`;
            }
            $('#Aparatos_listar').append(table);
        })
    })
};

(function() {
    listar();

    $('#btn-guardar').on('click', function () {

        $('#registrar').submit();
    });

    $('#btn-guardar1').on('click', function () {
        $('#Modificar').submit();
    });

    $('#btn-guardar2').on('click',function () {
        const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

        var url = contextPath + '/ServletGadgets?action=Eliminar';
        console.log(url);
        $('#Eliminar').attr('action',url);

        $('#Eliminar').submit();
        $('#ModalEliminar .btn-close').click();

    });

    $('#Aparatos_listar').on('click','.btn-modificar',function () {
        const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

        let id = $(this).attr('data-idprod');

        $.ajax({
            type: 'POST',
            url: contextPath + '/ServletGadgets?action=Listar',
            data: {id: id}
        }).done(function (res) {
            let aparato = res.aparato;

            $('#id').val(aparato.id);
            $('#aparato').val(aparato.nombre);
            $('#fecha').val(aparato.fecharegistro);
            $('#calle').val(aparato.direccion_fabricante.calle);
            $('#colonia').val(aparato.direccion_fabricante.colonia);
            $('#codigo_postal').val(aparato.direccion_fabricante.codigo_postal);
            $('#estado').val(aparato.direccion_fabricante.estado);
            $('#pais').val(aparato.direccion_fabricante.pais);
        })
    });

    $('#Aparatos_listar').on('click','.btn-eliminar',function () {
        const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

        let id = $(this).attr('data-idprod');

        $.ajax({
            type: 'POST',
            url: contextPath + '/ServletGadgets?action=Listarid',
            data: {id1: id}
        }).done(function (res) {
            console.log(res.aparato);
            let aparato = res.aparato;

            $('#id').val(aparato.id);
            $('#aparato').val(aparato.nombre);
        })
    });

    $('#Aparatos_listar').on('click','.btn-detalles',function () {
        const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

        let id = $(this).attr('data-id');

        $.ajax({
            type: 'POST',
            url: contextPath + '/ServletGadgets?action=ListarId',
            data: {id1: id}
        }).done(function (res) {
            let aparato = res.aparato;

            $('#id1').val(aparato.id);
            $('#aparato1').val(aparato.nombre);
            $('#fecha1').val(aparato.fecharegistro);
            $('#calle1').val(aparato.direccion_fabricante.calle);
            $('#colonia1').val(aparato.direccion_fabricante.colonia);
            $('#codigo_postal1').val(aparato.direccion_fabricante.codigo_postal);
            $('#estado1').val(aparato.direccion_fabricante.estado);
            $('#pais1').val(aparato.direccion_fabricante.pais);
        })
    });

    $('#registrar').submit(function (e) {
        const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

        e.preventDefault();
        var form = $(this);
        var url = form.attr('action');
        console.log(url);
        $.ajax({
            type: 'POST',
            url: contextPath + url,
            data: {
                txtnombre: $('#aparato').val(),
                txtfechareg: $('#fecha').val(),
                txtcalle: $('#calle').val(),
                txtcolonia: $('#colonia').val(),
                txtcodigopostal: $('#codigo_postal').val(),
                txtestado: $('#estado').val(),
                txtpais: $('#pais').val()}
        }).done(function (data) {
            console.log("Registrado");

            listar();
            $('#Modalregistro .btn-close').click();
        }).fail(function(data) {
            console.log("A ocurrido un error al registrar");
        });
    })
})();
