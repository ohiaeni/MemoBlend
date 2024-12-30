<script setup lang="ts">
import { Calendar } from 'v-calendar';

const onDayClick = (day: Date) => {
  window.location.href = 'https://github.com';
};
</script>

<template>
  <main>
    <Calendar expanded @dayclick="onDayClick" />
  </main>
</template>
