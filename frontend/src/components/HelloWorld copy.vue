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
      ></v-select>
      </v-col>
      <v-col cols="12" md="2" class="mt-5">
      <v-text-field 
        v-model="uname" 
        label="이름" 
        color="#FFFF0000"
        @change="getEvents"
      ></v-text-field>
      </v-col>
      <v-btn icon @click="otherPeople" class="mt-13">
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
      upjt:'',
      items: ['전체', '프레시웨이 클라우드 전환 2단계', '대한통운 NEXT WMS 구축', 'ODS 리뉴얼 프로젝트', 'ODS 고도화 프로젝트', 
              'TVING PJT', '제일제당 PLM 구축 프로젝트', '신한은행 스토리뱅크 프로젝트', 'CGV 광고운영통합시스템 구축', 'FrameOne'],
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
      otherPeople(){
        this.events.push({ 
              name: "PM님 반차",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-07'),
              end: new Date('2022-04-07'),
              color: this.colors[4],
              // timed: !allDay,
            },
            { 
              name: "PM님 재택",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-12'),
              end: new Date('2022-04-13'),
              color: this.colors[4],
              // timed: !allDay,
            })
      },
      getEvents () {
        console.log(this.pjt)
        let events = [
            { 
              name: "김나현님 재택",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-08'),
              end: new Date('2022-04-08'),
              color: this.colors[0],
              // timed: !allDay,
            },
            { 
              name: "김나현님 재택",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-15'),
              end: new Date('2022-04-15'),
              color: this.colors[0],
            },
            { 
              name: "김나현님 재택",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-20'),
              end: new Date('2022-04-20'),
              color: this.colors[0],
            },
            { 
              name: "김나현님 공가",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-11'),
              end: new Date('2022-04-12'),
              color: this.colors[0],
            },
            { 
              name: "권은님 휴가",
              pjt:'프레시웨이 클라우드 전환 2단계',
              start: new Date('2022-04-19'),
              end: new Date('2022-04-27'),
              color: this.colors[1],
            },
            { 
              name: "허예슬님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-01'),
              end: new Date('2022-04-01'),
              color: this.colors[3],
            },
            { 
              name: "허예슬님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-07'),
              end: new Date('2022-04-08'),
              color: this.colors[3],
            },
            { 
              name: "임창빈님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-01'),
              end: new Date('2022-04-01'),
              color: this.colors[2],
            },
            { 
              name: "임창빈님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-08'),
              end: new Date('2022-04-08'),
              color: this.colors[2],
            },
            { 
              name: "허예슬님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-14'),
              end: new Date('2022-04-15'),
              color: this.colors[3],
            },
            { 
              name: "임창빈님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-14'),
              end: new Date('2022-04-15'),
              color: this.colors[2],
            },
            { 
              name: "허예슬님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-21'),
              end: new Date('2022-04-22'),
              color: this.colors[3],
            },
            { 
              name: "임창빈님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-21'),
              end: new Date('2022-04-22'),
              color: this.colors[2],
            },
            { 
              name: "허예슬님 재택",
              pjt: 'ODS 고도화 프로젝트',
              start: new Date('2022-04-28'),
              end: new Date('2022-04-29'),
              color: this.colors[3],
            },
        ]
        this.events=events

        if(this.upjt!=''&&this.uname!=''){
          console.log(1)
          console.log(this.upjt)
          console.log(this.uname)
          let temp=[]
          for(let i=0;i<events.length;i++){
            if(!events[i].name.indexOf(this.uname)&&(!events[i].pjt.indexOf(this.upjt)||this.upjt=='전체')) temp.push(events[i])
          }
          this.events=temp  
        }else if(this.uname!=''){
          console.log(2)
          console.log(this.upjt)
          console.log(this.uname)
          let temp=[]
          for(let i=0;i<events.length;i++){
            if(!events[i].name.indexOf(this.uname)) temp.push(events[i])
          }
          this.events=temp
        } else if(this.upjt!=''){
          console.log(3)
          console.log(this.upjt)
          console.log(this.uname)
          if(this.upjt!='전체'){
            let temp=[]
            for(let i=0;i<events.length;i++){
              if(!events[i].pjt.indexOf(this.upjt)) temp.push(events[i])
            }
            this.events=temp
          }
        }
      },
      getEventColor (event) {
        return event.color
      },
      rnd (a, b) {
        return Math.floor((b - a + 1) * Math.random()) + a
      },
    },
  }
</script>
<style scoped>
#title{
  font-weight: 200;
  font-size: 20px;
}
</style>