<template>
    <div class="main">
        <nav class="header_ul">
            <li v-for="(item, index) in items" :key="index">
                {{ item.text }}
                <div :class="nav">
                    
                </div>
            </li>
        </nav>
    </div>
</template>
    
<script setup lang="ts">
let id: number = 0;

const items = [
    {
        text: id++
    },
    {
        text: id++
    },
    {
        text: id++
    },
    {
        text: id++
    },
    {
        text: id++
    },
]
</script>
    
<style scoped>
.main {
    width: 100%;
    height: 100%;
}

.header_ul {
    display: flex;
    justify-content: center;
    width: 100%;
    list-style: none;
}

.header_ul li {
    margin: 0 90px;
}
</style>