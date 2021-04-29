<template>
    <form>
        <h3>Login</h3>
        <div class="form-group">
            <label>User name</label>
            <input type="text" class="form-control" placeholder="User name"/>
        </div>
        <div class="form-group">
            <label>password</label>
            <input type="password" class="form-control" placeholder="Password"/>
        </div>
        <button class="btn btn-primary btn-block">Login</button>
    </form>
</template>

<script>
    export default {
        name: 'Login'
    }
</script>
