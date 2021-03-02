<template>
  <div class="w-full p-7">
    <div class="flex flex-col justify-center items-center w-full">
      <table class="table-auto shadow-lg" v-if="books.length">
        <thead>
          <tr class="font-bold text-lg bg-indigo-400 text-white border-t-0">
            <th class="py-4 px-6 rounded-tl-md">Title</th>
            <th class="py-4 px-6">Created at</th>
            <th class="py-4 px-6 rounded-tr-md">Modified at</th>
          </tr>
        </thead>
        <tbody>
          <tr
            class="hover:bg-gray-100 last:rounded-b-md"
            v-for="book in books"
            :key="book.id.toString()"
          >
            <td class="py-4 px-6 border-b border-grey-light text-gray-700">
              {{ book.title }}
            </td>
            <td class="py-4 px-6 border-b border-grey-light text-gray-700">
              {{ book.createdDate }}
            </td>
            <td class="py-4 px-6 border-b border-grey-light text-gray-700">
              {{ book.modifiedDate }}
            </td>
          </tr>
        </tbody>
      </table>
      <h1 v-else>You haven't written any books!</h1>

      <div class="flex justify-between w-full mt-10">
        <button
          type="button"
          @click.prevent="handleLogout"
          class="w-auto rounded-md bg-indigo-400 p-2 text-md focus:outline-none text-white font-bold mb-3"
        >
          Add new book
        </button>

        <button
          type="button"
          @click.prevent="handleLogout"
          class="w-auto rounded-md bg-indigo-400 p-2 text-md focus:outline-none text-white font-bold mb-3"
        >
          Logout
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import bookDS from "../../services/BookDataService";
export default {
  data() {
    return {
      books: [
        { id: String, title: String, createdDate: Date, modifiedDate: Date },
      ],
    };
  },
  methods: {
    getAllBooks() {
      bookDS
        .getBooks()
        .then((response) => {
          this.books = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    handleLogout() {
      this.$store
        .dispatch("auth/logout")
        .then(() => {
          this.$router.push("/login");
        })
        .catch((error) => {
          console.log("error accepted! " + error);
        });
    },
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.getAllBooks();
    }
  },
};
</script>

<style></style>
