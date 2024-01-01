<template>
    <el-scrollbar max-height="750px">
   <h1 style="text-align: center;font-size: 24px;color: black;">线上考试系统</h1>
    <li v-for="(item, index) in tableData" :key="index" class="text">
        <h5>
        第{{ index+1 }}题</h5>
        <br>
        {{item.question.context}}
        <br>
        <img v-if="item.question.imageUrl !==''" :src="item.question.imageUrl" alt="图片"  width="200" height="200">
        <br>
        <br>
        你的答案
        <input  class="input-line"   v-model="sequence[index]">
        <hr>
    </li>
    <br>
    <br> 
    <br>
    <el-button type="primary" justify-content: center size="large" @click="addValue">提交</el-button>
</el-scrollbar>
</template>
<script lang="ts" setup>
import { ref,onMounted } from 'vue'
import { ElMessageBox } from 'element-plus'
import axios from 'axios'
import {useidStore,course_classinfoStore,classidStore,examidStore} from '@/stores/counter'
import httpInstance from '../../utils/http';
import httpParams from '@/utils/httpparam';
const imageUrl =ref('');
const examid=ref(examidStore().id);
const userid=ref(useidStore().id);
let  scores=0;
const requestData2 = {
    examId:examid.value,
}
const tableData=ref([]);
const sequence=ref([]);
const requestData3={
    answer:sequence,
    examId:examid,
    scores: scores,
    studentId:userid
}
onMounted(() => { 
  httpParams.post('/student/getExamInfo', requestData2)
  .then(response => {
    console.log(response.data);
    tableData.value=response.data.data
    console.log('asdasdasd:'+tableData.value[0].examQuestion.createTime)
  })
  .catch(error => {
    console.log(error);
    // 注册失败，可以根据实际需求进行处理，比如显示错误提示
    alert(examid.value);
  });
  console.log(`the component is now mounted.`) })
  const addValue = () => {
    
    for (let i = 0; i < sequence.value.length; i++) {
   // console.log(sequence.value[i]);
    if(sequence.value[i]===tableData.value[i].question.answer)
    {
        scores+=tableData.value[i].examQuestion.scores;
    }
   }
   console.log('成绩'+scores);
   alert('本次考试成绩：'+scores)
//    httpInstance.post('/student/submit', requestData3)
//   .then(response => {
//     console.log(response.data);
//     tableData.value=response.data.data
//     console.log('asdasdasd:'+tableData.value[0].examQuestion.createTime)
//   })
//   .catch(error => {
//     console.log(error);
//     // 注册失败，可以根据实际需求进行处理，比如显示错误提示
//     alert(examid.value);
//   });
  };
</script>
<style >
.text{
    color:black;
    font-size: 20px
}
.input-line {
    border: none;
    border-bottom: 1px solid #ccc; /* 将边框设置为下划线 */
    padding: 4px;
    outline: none; /* 去掉输入框的聚焦样式 */
    background:  #f0f8ff ;
    right: 0;
  }
</style>