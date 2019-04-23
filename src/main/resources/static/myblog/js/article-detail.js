var editor = new Simditor({
    toolbar: [
        'title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale',
        'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link',
        'image', 'hr', '|', 'alignment','code'
    ],
    textarea: $('#content'),
    placeholder: '写点什么...',
    //defaultImage: '/static/home/images/logo.png',
    imageButton: ['upload'],
    codeLanguage:'Java',
    upload: {
        url: '/article/upload',
        fileKey: 'file',
        leaveConfirm: '正在上传文件..',
        connectionCount: 3
    }
});

function publish() {
    //todo  校验
    $.post({
        url: 'publish',
        data:JSON.stringify({
            "title":$("#title").val(),
            "catalog":$("#catalog").val(),
            "summary":$("#summary").val(),
            "content": editor.getValue()
        }),
        dataType:'json',
        contentType:'application/json',
        success: function (result) {
            if (result.status===200) {
                alert("发布成功")
            } else {
                alert("发布失败");
            }
        }
    });
    return false;
}
//自动生成摘要
function getSummary() {
    
}

//存为草稿
function draft() {
    
}






