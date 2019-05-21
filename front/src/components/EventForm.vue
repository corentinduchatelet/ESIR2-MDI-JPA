<template>
  <div id="event-form">
    <form @submit.prevent="handleSubmit">
      <h4>Formulaire de création d'événement</h4>
      <label>Nom de l'événement</label>
      <input
        ref="first"
        type="text"
        :class="{ 'has-error': submitting && invalidName }"
        v-model="event.name"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
      <label>Description de l'événement</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidDescription }"
        v-model="event.description"
        @focus="clearStatus"
      >
      <p
        v-if="error && submitting"
        class="error-message"
      >❗Remplissez les cases</p>
      <p
        v-if="success"
        class="success-message"
      >✅Événément ajouté!</p>
      <button>Ajouter  l'événement</button>
    </form>

  </div>
</template>

<script>
export default {
  name: 'event-form',
  data() {
    return {
      error: false,
      submitting: false,
      success: false,
      event: {
        name: '',
        email: '',
      }
    }
  },
  computed: {
    invalidName() {
      return this.event.name === ''
    },

    invalidDescription() {
      return this.event.description === ''
    },
  },
  methods: {
    handleSubmit() {
      this.clearStatus()
      this.submitting = true

      if (this.invalidName || this.invalidDescription) {
        this.error = true
        return
      }

      this.$emit('add:event', this.event)
      this.$refs.first.focus()
      this.event = {
        name: '',
        description: '',
      }
      this.success = true
      this.error = false
      this.submitting = false
    },

    clearStatus() {
      this.success = false
      this.error = false
    }
  }}
</script>

<style scoped>
form {
  margin-bottom: 2rem;
}

[class*="-message"] {
  font-weight: 500;
}

.error-message {
  color: #d33c40;
}

.success-message {
  color: #32a95d;
}
</style>
