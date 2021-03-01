<template>
  <div class="flex h-screen w-full justify-center items-center">
    <div
      class="w-1/2 h-auto rounded-lg bg-gray-50 pl-5 pr-5 flex flex-col items-center shadow-md"
    >
      <img
        class="flex justify-center items-center mb-5"
        id="profile-img"
        src="https://img.icons8.com/fluent/344/year-of-tiger.png"
      />
      <div class="w-full mb-5 mx-auto flex flex-col">
        <form autocomplete="off" @submit.prevent="handleRegister">
          <input
            type="text"
            placeholder="Your Name"
            class="w-full text-lg text-gray-700 border-b border-gray-400 p-2 outline-none m-auto mb-3"
            autocomplete="off"
            v-model="user.name"
            v-validate="'required|min:3|max:20'"
            name="name"
          />
          <label v-if="errors.has('name')" class="text-sm text-red-700">{{
            errors.first("name")
          }}</label>

          <input
            type="text"
            placeholder="Username"
            class="w-full text-lg text-gray-700 border-b border-gray-400 p-2 outline-none mb-3"
            autocomplete="off"
            v-model="user.username"
            name="username"
            v-validate="'required|min:3|max:20'"
          />
          <label v-if="errors.has('username')" class="text-sm text-red-700">{{
            errors.first("username")
          }}</label>

          <input
            type="password"
            placeholder="Password"
            class="w-full text-lg text-gray-700 border-b border-gray-400 p-2 outline-none m-auto mb-3"
            autocomplete="off"
            v-model="user.password"
            name="password"
            v-validate="'required|min:6|max:40'"
          />
          <label v-if="errors.has('password')" class="text-sm text-red-700">{{
            errors.first("password")
          }}</label>

          <button
            class="w-full rounded-md bg-indigo-400 p-2 text-lg focus:outline-none text-white font-bold mb-3"
          >
            Sign up
          </button>

          <p class="w-full text-center text-gray-600 text-sm">
            Already have an account?
            <router-link to="/login">
              <button class="font-bold focus:outline-none outline-none">
                Login
              </button>
            </router-link>
            here
          </p>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import User from "../../models/user";
export default {
  data() {
    return {
      user: new User("", "", ""),
      submitted: false,
      successful: false,
      message: "",
    };
  },
  methods: {
    handleRegister() {
      this.$validator.validate().then((isValid) => {
        if (isValid) {
          this.$store.dispatch("auth/register", this.user).then(
            (data) => {
              this.message = data.message;
              this.successful = true;
              this.$router.push("/login");
            },
            (error) => {
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
              this.successful = false;
            }
          );
        }
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
      this.$router.push("/books");
    }
  },
};
</script>

<style>
</style>