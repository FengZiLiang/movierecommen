<template>
  <div class="a">
    <span @click="handleDrop">{{active>-1?list[active]:"请评分"}}</span>
    <div class="z">
      <ul v-show="visible" >
        <li v-for="(item,index) in list" :class="index===active?'active':''" @click="choose(item,index)" :key="index">
          {{item}}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ScoreMovie',
  props: ['list'],
  data () {
    return {
      visible: false,
      active: -1
    }
  },
  methods: {
    choose (item, index) {
      this.visible = false
      if (this.active !== index) {
        this.active = index

        this.$emit('selected', {
          index: index,
          label: item.label,
          value: item.value
        })
      }
    },
    handleDrop () {
      this.visible = !this.visible
    },
    outClick (e) {
      let dropRef = this.$el
      if (!dropRef.contains(e.target) && this.visible) {
        this.visible = false
      }
    }
  },

  mounted () {
    document.addEventListener('click', this.outClick)
  },
  destroyed () {
    document.removeEventListener('click', this.outClick)
  }
}
</script>

<style scoped>
.a{
  position: relative;
  width: 200px;
  display: inline-block;
  text-align: center;
  user-select: none;

color: #125165;
}
.a>span{
  padding: 5px 5px;
  background-color: lightblue;
  display: block;
  box-shadow: inset 0 0 0 2px #125165;

  color:  #125165;
}
.z>ul{
  list-style: none;
  margin: 0;
   position: absolute;
  top:10px;
  padding-inline-start: 0;

  background-color: lightblue;
  left: 0;
  /*left 不包含border*/
  width: 100%;
  box-shadow: inset 0 0 0 2px #125165;

}

.z>ul>li{
  padding: 10px 0;
}
.z{
  position: relative;
}
.z>ul>li:hover,div>ul>li.active{
  background-color: #125165;
  color: lightblue;
}
</style>
