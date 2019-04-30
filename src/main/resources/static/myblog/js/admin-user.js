function save() {
    console.log($("#userInfo").serializeJSON());
    $.post({
        url: 'user/updateUserInfo',
        data:JSON.stringify($("#userInfo").serializeJSON()),
        contentType:'application/json',
        success: function (result) {
            if (result.status===200) {
                alert(result.data)
            } else {
                alert("修改失败");
            }
        }
    });
    return false;
}

