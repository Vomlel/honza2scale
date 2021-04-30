<template>
    <h1 class="style">{{msg}}</h1>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
        msg: ''
    }
  },
  mounted() {
    fetch("/api/messages/user/2")
            .then((response) => response.json())
            .then((data) => {
                this.msg = "Hello " + data.username + ". Your id is " + data.id;
            })
  }
}
</script>

<style>
    .style{
        color: blue;
    }
</style>