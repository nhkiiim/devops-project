<template>
  <div class= "mr-15 ml-15 mb-10">
    <v-sheet tile class="d-flex">
      <span class="mt-13" id="title" >DevOps팀 근태 캘린더</span>
      <v-spacer></v-spacer>
      <v-col cols="12" md="3" class="mt-5">
      <v-select
          v-model="upjt"
          :items="items"
          label="프로젝트"
          color="#FFFF0000"
          @change="getEvents"
          @click="getEvents"
      ></v-select>
      </v-col>
      <v-col cols="12" md="2" class="mt-5">
      <v-text-field 
        v-model="uname" 
        label="이름" 
        color="#FFFF0000"
        @change="getEventsByName"
      ></v-text-field>
      </v-col>
      <v-btn icon class="mt-13">
        <v-icon>mdi-account-arrow-down</v-icon>
      </v-btn>
      <v-btn icon @click="$refs.calendar.prev()" class="mt-13">
        <v-icon>mdi-chevron-left</v-icon>
      </v-btn>
      <v-btn icon @click="$refs.calendar.next()" class="mt-13">
        <v-icon>mdi-chevron-right</v-icon>
      </v-btn>
    </v-sheet>
    <v-sheet height="700">
      <v-calendar
        ref="calendar"
        v-model="value"
        :events="events"
        :type="type"
        :event-overlap-mode="mode"
        :event-overlap-threshold="5"
        :event-color="getEventColor"
        @change="getEvents"
      ></v-calendar>
    </v-sheet>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data: () => ({
      upjt:'전체',
      items: ['전체', '제일제당', '프레시웨이', 'ENM', '오쇼핑', 'TVING', '대한통운'],
      type: 'month',
      types: ['month', 'week', 'day', '4day'],
      mode: 'stack',
      modes: ['stack', 'column'],
      weekday: [1, 2, 3, 4, 5],
      weekdays: [
        { text: 'Mon - Sun', value: [1, 2, 3, 4, 5, 6, 0] },
      ],
      value: '',
      events: [],
      colors: ['#FF5C4D', '#FF9636', '#FFCD58', '#DAD870','#B1D3C5'],
      uname: ''
    }),
    methods: {
      getEvents(){
          let events = [];
          this.$axios.post('http://localhost:8080/api/schedule/project',{projectName:this.upjt}).then(function(response){
            let scheduleList = response.data.scheduleList;
            for(var s of scheduleList){
              if(s.offDt!=null){
                events.push({
                  name: `${s.memberName}님 연차`,
                  pjt: s.projectSeq,
                  start: new Date(s.offDt),
                  end: new Date(s.offDt),
                  color: '#FF5C4D'
                })
              }

              if(s.homeDt!=null){
                events.push({
                  name: `${s.memberName}님 재택`,
                  pjt: s.projectSeq,
                  start: new Date(s.homeDt),
                  end: new Date(s.homeDt),
                  color: '#FFCD58'
                })
              }
            }
        }).catch(function(error){
          console.log(error)
        })
        this.uname = '';
        this.events = events;
      },
      getEventsByName(){
          let events = [];
          this.$axios.post('http://localhost:8080/api/schedule/member',{memberName:this.uname}).then(function(response){
            let scheduleList = response.data.scheduleList;
            for(var s of scheduleList){
              if(s.offDt!=null){
                events.push({
                  name: `${s.memberName}님 연차`,
                  pjt: s.projectSeq,
                  start: new Date(s.offDt),
                  end: new Date(s.offDt),
                  color: '#FF5C4D'
                })
              }

              if(s.homeDt!=null){
                events.push({
                  name: `${s.memberName}님 재택`,
                  pjt: s.projectSeq,
                  start: new Date(s.homeDt),
                  end: new Date(s.homeDt),
                  color: '#FFCD58'
                })
              }
            }
        }).catch(function(error){
          console.log(error)
        })
        this.upjt='전체'
        this.events = events;
      },
    }
  }
</script>
<style scoped>
#title{
  font-weight: 200;
  font-size: 20px;
}
</style>