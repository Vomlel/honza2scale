<template>
    <form @submit.prevent="handleSubmit">
        <h3>Login</h3>
        <h3>{{msg}}</h3>
        <div class="form-group">
            <label>User name</label>
            <input type="text" class="form-control" v-model="userName" placeholder="User name"/>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" v-model="password" placeholder="Password"/>
        </div>
        <button class="btn btn-primary btn-block">Login</button>
    </form>
</template> //html sablona

<script>//javascript with vue
export default {
    name: 'Login',
    data() {
        return {
            userName: '',
            password: '',
            msg: ''
        }
    },
    mounted() {
        this.userName = window.userRegistryIn;
    },
    methods: {
        handleSubmit() {
            const data = {
                userName: this.userName,
                password: this.password
            };
            console.log(data);
            const request = {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(data)
            }
            fetch("/api/user/login", request)//this goes to backend
            .then((response) => response.json())//this is what comes from backend
            .then((data) => {
                if(data.userName==this.userName) {
                    window.userLoginIn = data.userName;
                    this.msg = data.userName + " welcome!";
                    this.$router.push('/');
                } else {
                    this.msg = "Wrong user name or password";
                }
            })
        }
    }
}
</script>
