window.onload = function () {
    $.ajax({
        url: "/users/is_valid",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            token: getCookie("user_token")
        }),
        success: function () {
            window.location = "/topics.html";
        }
    });
};