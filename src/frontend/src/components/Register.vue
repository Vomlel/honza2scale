<template>
    <form @submit="handleSubmit">
        <h3>Sign up</h3>
        <div class="form-group">
            <label>User name</label>
            <input type="text" class="form-control" placeholder="User name"/>
        </div>
        <div class="form-group">
            <label>password</label>
            <input type="password" class="form-control" placeholder="Password"/>
        </div>
        <button class="btn btn-primary btn-block">Sign up</button>
    </form>
</template>

<script>
export default {
    name: 'Register',
    methods: {
        handleSubmit(){

        }
    }
}
</script>
