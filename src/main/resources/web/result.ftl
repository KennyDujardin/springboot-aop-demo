
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Odd Result</title>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
<div id="box">
    <table border="2">
        <tr>
            <th>获胜场次</th>
            <th>平场次</th>
            <th>输场次</th>
        </tr>
        <tr>
            <td>{{msg.winTimes}}</td>
            <td>{{msg.drawTimes}}</td>
            <td>{{msg.lostTimes}}</td>
        </tr>
    </table>
    <div>
        详情
        <table border="1">
            <tr>
                <th>获胜场次</th>
                <th>平场次</th>
                <th>输场次</th>
                <th>详情</th>

            </tr>
            <tr v-for="(v,k) in msg.list">
                <td>{{v.id}}</td>
                <td>{{v.xinwen_name}}</td>
                <td>{{v.xinwen_type}}</td>
                <td>{{v.xinwen_text}}</td>
                <td>{{v.xinwen_date}}</td>
                <td>{{v.xinwen_yuan}}</td>
            </tr>
        </table>

    </div>
</div>
<script type = "text/javascript">
    window.onload = function(){
        var vm = new Vue({
            el:'#box',
            data:{
                msg:[],
            },
            mounted:function () {
                this.get();
            },
            methods:{
                get:function(){
                    //发送get请求
                    this.$http.get("http://localhost:8080/getAllRecordsByWinOdd?winOdd=3.1").then(function(res){

                        this.msg=res.body;

                    },function(){
                        console.log('请求失败处理');
                    });
                }
            }
        });
    }
</script>
</body>
</html>