<template>
    <h1>{{msg}}</h1>
    <h1>{{msg2}}</h1>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
        msg: '',
        msg2: ''
    }
  },
  mounted() {
    fetch("/api/messages/hello")
            .then((response) => response.text())
            .then((data) => {
                this.msg = data;
            })
    fetch("/api/messages/user/1")
            .then((response) => response.json())
            .then((data) => {
                this.msg2 = data.username;
            })
  }
}
</script>