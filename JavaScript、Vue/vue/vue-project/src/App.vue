<template>
  <div>
    <!-- <h1>{{message}}</h1> -->
    <!-- <element-view></element-view> -->

    <!-- 员工管理 -->
    <!-- <emp-view></emp-view> -->

    <router-view></router-view>

  </div>
</template>

<script>
// import EmpView from './views/tlias/EmpView.vue'
// import ElementView from './views/element/ElementView.vue'
export default {
  components: {/* EmpView */ /* ElementView */ },
  data() {
    return {
      message:"Hello vue"
    }
  },
  methods: {
    
  }
}
</script>

<style>

</style>
