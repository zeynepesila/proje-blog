<template>
  <div class="login-container">
    <h2>LOG IN</h2>
    <form @submit.prevent="handleLogin">
      <div class="form-group">
        <label for="email">E-posta:</label>
        <input type="email" v-model="email" id="email" required />
      </div>

      <div class="form-group">
        <label for="password">Password:</label> <!-- 'Passeord' yerine 'Password' -->
        <input type="password" v-model="password" id="password" required />
      </div>

      <button type="submit">Log In</button>
    </form>

    <p class="signup-link">
      Not a member yet?
      <router-link to="/signup">Sign Up</router-link>
    </p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "Login",
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
   async handleLogin() {
  try {
    const response = await axios.post('http://localhost:8080/api/auth/login', {
      email: this.email,
      passwordHash: this.password
    });

    const user = response.data;
    // Backend'den gelen kullanıcı verisini localStorage'a kaydet
    localStorage.setItem('token', user.token);
    localStorage.setItem('role', user.role);

    // Rolüne göre yönlendir
    if (user.role === 'admin') {
      this.$router.push('/admin');
    } else {
      this.$router.push('/'); // Normal kullanıcı ana sayfasına
    }

  } catch (error) {
    alert("Giriş başarısız");
    console.error(error);
  }
}
  }
};
</script>

<style>
/* İsteğe bağlı: temel stil örneği */
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
.form-group {
  margin-bottom: 15px;
}
</style>
