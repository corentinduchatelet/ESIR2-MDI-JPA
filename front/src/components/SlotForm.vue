<template>
  <div id="slot-form">
    <form @submit.prevent="handleSubmit">
      <h4>Formulaire d'ajout de choix de date</h4>
      <label>Id de l'événement</label>
      <input
        ref="first"
        type="text"
        :class="{ 'has-error': submitting && invalidEventId }"
        v-model="slot.eventId"
        @focus="clearStatus"
        @keypress="clearStatus"
      >
      <label>Date de fin</label>
      <input
        type="date"
        :class="{ 'has-error': submitting && invalidBeginDate }"
        v-model="slot.beginDate"
        @focus="clearStatus"
      >
      <label>Date de début</label>
      <input
        type="date"
        :class="{ 'has-error': submitting && invalidEndDate }"
        v-model="slot.endDate"
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
      <button>Ajouter un choix de date à l'événement</button>
    </form>

  </div>
</template>

<script>
export default {
  name: 'slot-form',
  data() {
    return {
      error: false,
      submitting: false,
      success: false,
      slot: {
        eventId: '',
        beginDate: '',
        endDate: '',
      }
    }
  },
  computed: {
    invalidEventId() {
      return this.slot.eventId === ''
    },
    invalidBeginDate() {
      return this.slot.beginDate === ''
    },
    invalidEndDate() {
      return this.slot.endDate === ''
    },
  },
  methods: {
    handleSubmit() {
      this.clearStatus()
      this.submitting = true

      if (this.invalidEventId || this.invalidBeginDate || this.invalidEndDate) {
        this.error = true
        return
      }

      this.$emit('add:slot', this.slot)
      this.$refs.first.focus()
      this.slot = {
        eventId: '',
        beginDate: '',
        endDate: '',
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
