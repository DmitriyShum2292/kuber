{{- define "mychart.version" }}
        version: 1.0.0
{{- end }}

{{- define "mychart.date" }}
        date: {{ now | htmlDate }}
{{- end }}