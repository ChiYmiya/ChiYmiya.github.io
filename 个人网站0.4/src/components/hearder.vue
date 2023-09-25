<template>
    <header>
        <ul class="header_ul">
            <li class="ul_list" v-for="(item, index) in ul_list" :key="index">
                <a href="">{{ item.text }}</a>
                
            </li>
        </ul>
    </header>
</template>
  
<script setup lang="ts">
let id:number = 0;
let imgurl:string[]=[];
const ul_list = [{
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
}]
</script>
  
<style scoped>
.ul_list {
    display: inline-block;
    margin: 2px 90px;
}

.header_ul {
    width: 100%;
    display: flex;
    justify-content: center;
}
</style>
  
  