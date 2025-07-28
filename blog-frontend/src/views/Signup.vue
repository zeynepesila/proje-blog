<template>
  <div class="signup-container">
    <h2>SIGN UP</h2>
    <form @submit.prevent="handleSignup">
     
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" v-model="username" id="username" required />
      </div>

      <div class="form-group">
        <label for="email">E-posta:</label>
        <input type="email" v-model="email" id="email" required />
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" v-model="passwordHash" id="password" required />
      </div>

      <div class="form-group">
        <label for="role">User Role:</label>
        <select v-model="role" id="role" required>
          <option value="" disabled>Choose Role</option>
          <option value="user">Normal User</option>
          <option value="editor">Editor</option>
        </select>
      </div>

      <button type="submit">Sign up</button>
    </form>

    <p class="login-link">
      Do you already have an account?
      <router-link to="/">Sign in</router-link>
    </p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Signup',
  data() {

    return {
      username: '',
      email: '',
      passwordHash: '',
      role: ''
    };
  },
  methods: {
    async handleSignup() {
      try {
        const response = await axios.post('http://localhost:8080/api/auth/register', {
          username: this.username,
          email: this.email,
          passwordHash: this.password,
          role: this.role
        });

        alert("Kayit başarili! Giriş sayfasina yönlendiriliyorsunuz.");
        this.$router.push('/');
      } catch (error) {
        alert("Kayıt başarısız! Lütfen tekrar deneyin.");
        console.error(error);
      }
    }
  }
};
</script>

<style>
.signup-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
.form-group {
  margin-bottom: 15px;
}
</style>
