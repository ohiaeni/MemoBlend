<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <nav class="w-full">
      <div class="flex justify-between max-w-5xl mx-auto">
        <div>MemoBlend</div>
        <div>
          <RouterLink to="/">Home</RouterLink> |
          <RouterLink to="/about">About</RouterLink>
        </div>
      </div>
    </nav>
  </header>
  <main>
    <RouterView />
  </main>
</template>
