<template>
    <div>
      <h1>LOGIN</h1>
      <form>
        <div id="userPass">
          <input type="text" placeholder="user name" required/>
          <input type="password" placeholder="password" required/>
        </div>
        <div id="login">
          <button v-on:click="login">Login</button>
        </div>
      </form>
    </div>
</template>

<script>
export default {
  components: {

  },
  data() {
    return {

    }
  },
  methods: {
    
  }
}
</script>

<style scope>
    
</style>