
$(document).ready(function () {
    showboard();
})

function showboard(){
    // 1. GET /api/board 요청
    $.ajax({
        type: 'GET',
        url: '/api/board',
        success: function (response) {
            // 3. for 문마다 관심 상품 HTML 만들어서 관심상품 목록에 붙이기!
            for (let i = 0; i < response.length; i++) {
                let product = response[i];
                console.log(product)
                let tempHtml = addshowboard(product);
                $('#check').append(tempHtml);
            }
        }
    })

}

function addshowboard(product){
    return  `    <tr>
        <th scope="row">1</th>
        <td>${product.title}</td>
        <td>${product.name}</td>
        <td>${product.modifiedAt}</td>
    </tr>`
}