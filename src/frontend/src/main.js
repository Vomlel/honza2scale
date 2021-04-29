import App from './App.vue'
import router from './router'
import Vue from 'vue'

new Vue ({
    router,
    render: h => h(App),
}).$mount('#app')