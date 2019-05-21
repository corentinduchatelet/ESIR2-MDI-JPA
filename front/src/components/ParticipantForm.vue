<template>
  <div id="participant-form">
    <form @submit.prevent="handleSubmit">
      <h4>Formulaire d'ajout de participant</h4>
      <label>Id de l'événement</label>
      <input
        ref="first"
        type="text"
        :class="{ 'has-error': submitting && invalidEventId }"
        v-model="participant.eventId"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
      <label>Nom du participant</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidName }"
        v-model="participant.name"
        @focus="clearStatus"
      >
      <label>Prénom du participant</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidSurname }"
        v-model="participant.surname"
        @focus="clearStatus"
      >
      <label>Email du participant</label>
      <input
        type="text"
        :class="{ 'has-error': submitting && invalidEmail }"
        v-model="participant.email"
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
      <button>Ajouter  le participant à l'événement</button>
    </form>

  </div>
</template>

<script>
export default {
  name: 'participant-form',
  data() {
    return {
      error: false,
      submitting: false,
      success: false,
      participant: {
        eventId: '',
        name: '',
        surname: '',
        email: '',
      }
    }
  },
  computed: {
    invalidEventId() {
      return this.participant.eventId === ''
    },
    invalidName() {
      return this.participant.name === ''
    },
    invalidSurname() {
      return this.participant.surname === ''
    },
    invalidEmail() {
      return this.participant.email === ''
    },
  },
  methods: {
    handleSubmit() {
      this.clearStatus()
      this.submitting = true

      if (this.invalidName || this.invalidEventId || this.invalidSurname || this.invalidEmail ) {
        this.error = true
        return
      }

      this.$emit('add:participant', this.participant)
      this.$refs.first.focus()
      this.participant = {
        eventId: '',
        name: '',
        surname: '',
        email: '',
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
