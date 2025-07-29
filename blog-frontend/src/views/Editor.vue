<template>
  <div class="editor">
    <h1>Yeni Yazı Oluştur</h1>

    <form @submit.prevent="submitPost">
      <div class="form-group">
        <label for="title">Başlık</label>
        <input v-model="title" type="text" id="title" required />
      </div>

      <div class="form-group">
        <label for="summary">Özet</label>
        <textarea v-model="summary" id="summary" rows="3" required></textarea>
      </div>

      <div class="form-group">
        <label for="content">İçerik</label>
        <textarea v-model="content" id="content" rows="8" required></textarea>
      </div>

      <button type="submit">Yazıyı Yayınla</button>
    </form>

    <p v-if="successMessage" class="success">{{ successMessage }}</p>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Editor',
  data() {
    return {
      title: '',
      summary: '',
      content: '',
      successMessage: '',
      errorMessage: ''
    }
  },
  methods: {
    async submitPost() {
      try {
        const token = localStorage.getItem('token')
        await axios.post('/api/posts', {
          title: this.title,
          summary: this.summary,
          content: this.content
        }, {
          headers: {
            Authorization: `Bearer ${token}`
          }
        })

        this.successMessage = 'Yazı başarıyla yayınlandı!'
        this.errorMessage = ''
        this.title = ''
        this.summary = ''
        this.content = ''
      } catch (error) {
        this.successMessage = ''
        this.errorMessage = 'Yazı yayınlanırken bir hata oluştu.'
        console.error(error)
      }
    }
  }
}
</script>

<style scoped>
.editor {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
}
.form-group {
  margin-bottom: 15px;
}
input,
textarea {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
}
button {
  padding: 10px 20px;
  background-color: #0066cc;
  color: white;
  border: none;
  cursor: pointer;
}
.success {
  color: green;
  margin-top: 10px;
}
.error {
  color: red;
  margin-top: 10px;
}
</style>
 