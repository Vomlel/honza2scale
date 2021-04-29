<template>
    <form @submit.prevent="handleSubmit">
        <h3>Sign up</h3>
        <h3>{{msg}}</h3>
        <div class="form-group">
            <label>User name</label>
            <input type="text" class="form-control" v-model="userName" placeholder="User name"/>
        </div>
        <div class="form-group">
            <label>password</label>
            <input type="password" class="form-control" v-model="password" placeholder="Password"/>
        </div>
        <button class="btn btn-primary btn-block">Sign up</button>
    </form>
</template>

<script>
export default {
    name: 'Register',
    data() {
        return {
            userName: '',
            password: '',
            msg: ''
        }
    },
    methods: {
        handleSubmit(){
            const data = {
                userName: this.userName,
                password: this.password
            };
            console.log(data);
            const request ={
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(data)
            }
            fetch("/api/user/register", request)
            .then((response) => response.json())
            .then((data) => {
                this.msg = data.userName + " registered";
                this.$router.push('/login');
            })
        }
    }
}
</script>
