import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
});

export const useidStore = defineStore('useid', () => {

  const id =ref()
  const name=ref('')
  const setid = (newid,newname)=>{
      id.value = newid;
      console.log(newname);
      name.value=newname;
  }
  return {
    id,
    setid ,
    name
  }
},
  {
    persist: true,
  },



);
export const course_classinfoStore = defineStore('cou_classinfo', () => {

  const id =ref()
  const setid = (newid)=>{
    id.value = newid;
      console.log(newid);
  }
  return {
    id,
    setid ,
  }
},
  {
    persist: true,
  },



);
export const classidStore = defineStore('classid', () => {

  const id =ref()
  const setid = (newid)=>{
    id.value = newid;
      console.log(newid);
  }
  return {
    id,
    setid ,
  }
},
  {
    persist: true,
  },



);
export const examidStore = defineStore('examid', () => {

  const id =ref()
  const setid = (newid)=>{
    id.value = newid;
      console.log(newid);
  }
  return {
    id,
    setid ,
  }
},
  {
    persist: true,
  },



);
