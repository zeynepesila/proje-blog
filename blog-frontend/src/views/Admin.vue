<template>
  <div class="admin-page">
    <AdminSidebar />
    <router-view />
  </div>
</template>

<script>
import AdminSidebar from '@/components/AdminSidebar.vue'

export default {
  name: 'Admin',
  components: {
    AdminSidebar
  }
}
</script>

<style scoped>
.admin-page {
  display: flex;
}
</style>
