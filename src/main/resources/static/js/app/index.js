var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.load();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
            var data = {
                imgName: $('#imgName').val(),
                imgUrl: $('#imgUrl').val(),
            };

            $.ajax({
                type: 'POST',
                url: '/api/idCard/save',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('생성중');
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },
    load : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    upload_block : function () {
            var data = {
                privateKey: $('#privateKey').val(),
                textData: $('textData').val()
            };

            $.ajax({
                type: 'GET',
                url: '/api/idCard/UserBlock',
                data: data,
                success:function(data){
                    alert(data.privateKey + textData);
                    console.log(data);
                }
            }).done(function() {
                alert('사진이 등록되었습니다.');
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
};

main.init();