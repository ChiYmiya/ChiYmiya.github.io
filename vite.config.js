import { defineConfig } from "vite";
export default defineConfig({
  base: "/ChiYmiya.github.io/",
  build: {
    minify: "terser",
    terserOptions: {
      compress: {
        drop_console: true,
      },
    },
  },
});
// vite.config.js
