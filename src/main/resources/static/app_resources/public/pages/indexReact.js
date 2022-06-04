'use strict';

const e = React.createElement;
const URL = "/colegio/api/students/all";
class IndexReact extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			data: []
		};
	}
	getStudents = () => {
		axios.get(URL).then(response => {
			console.log(response.data);
			this.setState({data: response.data})
		})
	}
	componentDidMount() {
		this.getStudents();
	}
	render() {
		return e("div", null, e(
			"table", null, e(
				"thead", null, e(
					"tr", null, e(
						 "th", null, "Nombre"),
						e("th", null, "Grado"),
						e("th", null, "Email")
					)
				), e(
				"tbody", null, this.state.data.map((student)=>{
					return (
						e("tr", null, 
							e("td", null, student.studentname),
							e("td", null, student.studentgrade),
							e("td", null, student.studentemail)
							));
				}))
			)
		)
			
		
	}
}

// Find all DOM containers, and render Like buttons into them.

const domContainer = document.querySelector('.index_react');
const root = ReactDOM.createRoot(domContainer);
root.render(e(IndexReact));