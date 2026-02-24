import { defineConfig } from "vite";
export default defineConfig({
  base: "/",
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
