<template>
    <h3>Hello {{msg}}</h3>
</template>

<script>
    export default {
        name: 'Home',
        data() {
            return {
                msg: ''
            }
        },
        mounted() {
            this.msg=window.userLoginIn //If is user login in, in body of home module is greetings to user.
        }
    }

</script>
