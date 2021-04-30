<template>
    <form @submit.prevent="handleSubmit">
        <h3>Sign up</h3>
        <h3>{{msg}}</h3>
        <div class="form-group">
            <label>User name</label>
            <input type="text" class="form-control" v-model="userName" placeholder="User name"/>
        </div>
        <div class="form-group">
            <label>Password</label>
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
        handleSubmit(){ //for submitting
            const data = {
                userName: this.userName,
                password: this.password
            };
            console.log(data); //check if we have data from properties
            const request ={ //creating request data for backend
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(data)
            }
            fetch("/api/user/register", request) //this goes to backend
            .then((response) => response.json()) //this is what comes from backend UserController //TODO - just recieve boolean value (and maybe reason if is not created) BUG #2
            .then((data) => {
                this.msg = data.userName + " registered"; //missing if like in Login.vue Bug #9
                window.userRegistryIn=data.userName;
                this.$router.push('/login'); //go to login page
            })
        }
    }
}
</script>
