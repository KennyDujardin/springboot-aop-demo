
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Vue 测试实例 - 菜鸟教程(runoob.com)</title>
    <script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
    <script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
<div id="box">
    <table border="1">
        <tr>
            <th>id</th>
            <th>标题</th>
            <th>类型</th>
            <th>详情</th>
            <th>添加时间</th>
            <th>信息来源</th>
            <th>操作</th>
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
                    this.$http.get("http://lpk.haoyunyun.cn/xinwena").then(function(res){

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