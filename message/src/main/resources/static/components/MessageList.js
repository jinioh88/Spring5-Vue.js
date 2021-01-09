export default {
    name: "MessageList",
    template: `
        <ul>
            <li v-for="message in messages">
                {{message.text}} - {{message.createdAt}}
                <button @click="deleteMessage(message)">X</button>
            </li>
         </ul>`,
    props: {
        items: {
            type: Array,
            required: true
        }
    },
    methods: {
        deleteMessage(message) {
            this.$emit('delete', message);
        }
    }
}