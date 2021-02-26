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
        <form autocomplete="off" @submit.prevent="">
          <input
            type="text"
            placeholder="Username"
            class="w-full text-lg text-gray-700 border-b border-gray-400 p-2 outline-none mb-3"
            autocomplete="off"
          />

          <input
            type="password"
            placeholder="Password"
            class="w-full text-lg text-gray-700 border-b border-gray-400 p-2 outline-none m-auto mb-3"
            autocomplete="off"
          />
          <button
            class="w-full rounded-md bg-indigo-400 p-2 text-lg focus:outline-none text-white font-bold mb-3"
          >
            Sign in
          </button>

          <p class="w-full text-center text-gray-600">
            Not having an account?
            <button class="font-bold focus:outline-none outline-none">
              Sign up
            </button>
            here
          </p>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {},
};
</script>

<style></style>
