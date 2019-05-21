<template>
  <div id="event-table">
    <h4>Événements</h4>
    <p v-if="events.length < 1" class="empty-table">
      Pas d'événements
    </p>
    <table v-else>
      <thead>
        <tr>
          <th>Id</th>
          <th>Nom</th>
          <th>Description</th>
          <th>Participants</th>
          <th>Dates</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr
          :key="event.id"
          v-for="event in events"
        >
          <td>{{event.id}}
          <td v-if="editing === event.id">
            <input
              type="text"
              v-model="event.name"
            >
          </td>
          <td v-else>{{event.name}}</td>
          <td v-if="editing === event.id">
            <input
              type="text"
              v-model="event.description"
            >
          </td>
          <td v-else>{{event.description}}</td>

          <td>
            <ul>
              <li :key="participant.email" v-for="participant in event.participants">
                {{participant.email}}
              </li>
            </ul>
          </td>
          <td>
            <ul>
              <li :key="slot.dateBegin" v-for="slot in event.slots">
                {{slot.dateBegin}} - {{slot.dateEnd}}
              </li>
            </ul>
          </td>

          <td v-if="editing === event.id">
            <button @click="editEvent(event)">Save</button>
            <button
              class="muted-button"
              @click="editing = null"
            >Cancel</button>
          </td>
          <td v-else>
            <button @click="editMode(event.id)">Edit</button>
            <button @click="$emit('delete:event', event.id)">Delete</button>
          </td>

        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'event-table',
  props: {
    events: Array,
  },
  data() {
    return {
      editing: null,
    }
  },
  methods: {
    editMode(id) {
      this.editing = id
    },

    editEvent(event) {
      if (event.name === '' || event.description === '') return
      this.$emit('edit:event', event.id, event)
      this.editing = null
    }
  }
}
</script>

<style scoped>
button {
  margin: 0 0.5rem 0 0;
}

input {
  margin: 0;
}

.empty-table {
  text-align: center;
}
</style>
