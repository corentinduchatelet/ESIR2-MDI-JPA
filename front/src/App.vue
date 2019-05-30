<template>
  <div
    id="app"
    class="small-container"
  >
    <h1>SmartDoodle</h1>

    <event-form @add:event="addEvent" />
    <hr width="75%">
    <event-table
      :events="events"
      @delete:event="deleteEvent"
      @edit:event="editEvent"
    />
    <hr width="75%">
    <slot-form @add:slot="addSlot" />
    <hr width="75%">
    <participant-form @add:participant="addParticipant" />
  </div>
</template>

<script>
import EventTable from '@/components/EventTable.vue'
import EventForm from '@/components/EventForm.vue'
import SlotForm from '@/components/SlotForm.vue'
import ParticipantForm from '@/components/ParticipantForm.vue'

const url = 'http://www.localhost:8080/doodle'

export default {
  name: "app",
  components: {
    EventTable,
    EventForm,
    SlotForm,
    ParticipantForm
  },
  data() {
    return {
      events: []
    }
  },

  mounted() {
    this.getEvents()
  },

  methods: {
    async getEvents() {
      try {
        const response = await fetch(url+"/events")
        const data = await response.json()
        this.events = data
        //this.events = [{id:123,name:'le feu',description:'ce cours de MDI',participants:[{email:'jj@hotmail.fr'},{email:'jj@hotmail.fr'},{email:'jj@hotmail.fr'}],slots:[{email:'jj@hotmail.fr'},{email:'jj@hotmail.fr'},{email:'jj@hotmail.fr'}]}]
      } catch (error) {
        console.error(error)
      }
    },

    async addEvent(event) {
      try {
        const response = await fetch(url+"/events", {
          method: 'POST',
          body: JSON.stringify(event),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        this.events = [...this.events, data]
      } catch (error) {
        console.error(error)
      }
    },

    async editEvent(id, updatedEvent) {
      try {
        const response = await fetch(url+"/events/"+id, {
          method: 'PUT',
          body: JSON.stringify(updatedEvent),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        this.events = this.events.map(event => event.id === id ? data : event)
      } catch (error) {
        console.error(error)
      }
    },

    async deleteEvent(id) {
      try {
        await fetch(url+"/events/"+id, {
          method: 'DELETE'
        })
        this.events = this.events.filter(event => event.id !== id)
      } catch (error) {
        console.error(error)
      }
    },

    async addSlot(slot) {
      try {
        const response = await fetch(url+"/slots", {
          method: 'POST',
          body: JSON.stringify(slot),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        console.log(data)
        //this.events = [...this.events, data]
        this.getEvents()
      } catch (error) {
        console.error(error)
      }
    },

    async addParticipant(participant) {
      try {
        const response = await fetch(url+"/participants", {
          method: 'POST',
          body: JSON.stringify(participant),
          headers: { "Content-type": "application/json; charset=UTF-8" }
        })
        const data = await response.json()
        console.log(data)
        //this.events = [...this.events, data]
        this.getEvents()
      } catch (error) {
        console.error(error)
      }
    }
  },
}
</script>

<style>
button {
  background: #009435;
  border: 1px solid #009435;
}

button:hover,
button:active,
button:focus {
  background: #32a95d;
  border: 1px solid #32a95d;
}

.small-container {
  max-width: 680px;
}
</style>
