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
        <button class="btn btn-primary btn-block" type="submit">Login</button>
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
        handleSubmit() { //for submitting
          console.log("test");
            const data = {
                userName: this.userName,
                password: this.password
            };
            console.log(data); //check if we have data from properties
            const request = { //creating request data for backend
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(data)
            }
            fetch("/api/user/login", request) //this goes to backend
            .then((response) => response.json()) //this is what comes from backend //TODO - just recieve boolean value BUG #1
            .then((data) => {
                if(data.userName === this.userName) { //if user with userName and password Exists
                    window.userLoginIn = data.userName; //better define global constant BUG #8
                    this.msg = data.userName + " welcome!"; //TODO - this doesn't have to be here BUG #7
                    this.$router.push('/'); //go to home
                } else {
                    this.msg = "Wrong user name or password";
                }
            })
        }
    }
}
</script>
