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
            this.msg=window.userLoginIn
        }
    }

</script>
