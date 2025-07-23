<template>
    <div class="login-container">
        <h2>LOG IN</h2>
        <form @submit.prevent="handleLogin">
            <div class="form-group">
                <label for="email">E-posta:</label>
                <input type="email" v-model="email" id="email" required/>
            </div>
            
            <div class="form-group">
            <label for="password">Passeord:</label>
            <input type="password" v-model="password" id="password" required/>
            </div>

            <button type="submit">Log In</button>

        </form>
        
        <p class="signup-link">

             Not a member yet?
             <router-link to="/signup">Sign Up </router-link>

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
          passwordHash: this.password   // 👈 backend’in beklediği alan ismi bu!
        });

        // Yanıt başarılıysa
        alert(response.data); // örneğin: "Login successful"
        
        // Giriş başarılıysa başka sayfaya yönlendirebilirsin
        // this.$router.push("/dashboard");

      } catch (error) {
        // Hata olursa
        alert("Giriş başarısız");
        console.error(error);
      }
    }
  }
};


</script>

<style>
</style>;