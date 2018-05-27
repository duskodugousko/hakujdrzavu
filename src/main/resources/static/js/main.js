$(document).ready(function () {

    $('.datepicker').datepicker({
        format: 'dd.mm.yyyy',
        changeYear: true,
        yearRange: '2018',
        changeMonth: true
    });

    $('.delete-btn').on('click', function (e) {
        var url = $(this).data('url');
        var returnUrl = $(this).data('new-url');
        var $this = $(this);
        $.ajax({
            data: {},
            url: url,
            type: 'DELETE',
            success: function () {
                // window.location.replace(returnUrl);
                window.location
                    .reload();
            }
        });
    });

});